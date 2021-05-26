 def call(Map params = [:] ) {
     def args = [
        NEXUS_IP : '172.31.9.137',
     ]
     args << params
    pipeline {
        agent {
            label "${args.SLAVE_LABEL}"
        }
        environment {
            COMPONENT="${args.COMPONENT}"
            NEXUS_IP = "${args.NEXUS_IP}"
            PROJECT_NAME = "${args.PROJECT_NAME}"
            SLAVE_LABEL = "${args.SLAVE.LABEL}"
            APP_TYPE    = "${args.APP_TYPE}"
        }
        stages {
            stage ('Prepare Artifacts - NGINX') {

                when {
                    environment name: 'APP_TYPE' , value : 'NGINX'
                }
                steps {
                    sh '''
                   echo ${COMPONENT}
                  zip -r ${COMPONENT}.zip *
               '''
                }
            }
            stage('compile code') {
                when {
                    environment name: 'APP_TYPE' , value : 'NODEJS'
                }
                steps {
                    sh '''
                    mvn compile
                  '''
                }
            }
            stage('make package') {
                when {
                    environment name: 'APP_TYPE' , value : 'NODEJS'
                }
                steps {
                    sh '''

                     mvn package
                 '''
                }
            }
            stage ('Prepare Artifacts - NODEJS') {
                steps {
                    sh '''
                  zip -r ${COMPONENT}.zip *
               '''
                }
            }

            stage('Upload Artifacts') {
                steps {
                    sh '''

                 curl -f -v -u admin:vamsi --upload-file frontend.zip http://172.31.9.137:8081/repository/frontend/frontend.zip
              '''
                }
            }
        }
    }

 }