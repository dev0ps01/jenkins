def call() {
    pipeline {
        agent any
        stages {
            stage ('Prepare Artifacts') {
                steps {
                    sh '''

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