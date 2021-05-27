 def call(Map params = [:] ) {
     def args = [
        NEXUS_IP : '172.31.9.137',
     ]
     args << params
    pipeline {
        agent {
            label "${args.SLAVE_LABEL}"
        }
        triggers {
            pollSCM('* * * * 1-5')
        }

        environment {
            COMPONENT="${args.COMPONENT}"
            NEXUS_IP = "${args.NEXUS_IP}"
            PROJECT_NAME = "${args.PROJECT_NAME}"
            SLAVE_LABEL = "${args.SLAVE_LABEL}"
            APP_TYPE    = "${args.APP_TYPE}"
        }
        stages {

            stage('compile code') {
                when {
                    environment name: 'APP_TYPE' , value : 'JAVA'
                }
                steps {
                    sh '''
                      mvn compile
                    '''
                }
            }
            stage('make package') {
                when {
                    environment name: 'APP_TYPE' , value : 'JAVA'
                }
                steps {
                    sh '''
                      mvn package
                    '''
                }
            }
            stage('Build code & install dependencies') {
                steps {
                    script {
                        build = new nexus()
                        build.code_build("${APP_TYPE}",${COMPONENT})
                    }
                }

            }

            stage('Prepare Artifacts') {

                steps {
                    script {
                        prepare = new nexus()


                        prepare.make_artifacts ("${APP_TYPE}","${COMPONENT}")
                    }
                }
            }

            stage('Upload Artifacts') {
                steps {
                    sh '''
                      curl -f -v -u admin:vamsi --upload-file frontend.zip http://${NEXUS_IP}:8081/repository/frontend/frontend.zip
                    '''
                }
            }
        }
    }

 }