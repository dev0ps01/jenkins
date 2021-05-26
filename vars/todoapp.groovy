 def call(Map params = [:] ) {
     def args = [
        NEXUS : 'some',
     ]
     args << params
    pipeline {
        agent any
        environment {
            COMPONENT="${args.COMPONENT}"
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