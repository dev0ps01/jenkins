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
        }
        stages {
            stage ('Prepare Artifacts') {
                steps {
                    sh '''
                   echo ${COMPONENT}
                  zip -r frontend.zip *
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