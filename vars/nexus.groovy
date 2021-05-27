def nexus() {
    command = "curl -f -v -u admin:vamsi --upload-file users.zip http://172.31.9.137:8081/repository/users/users.zip"
    def execute_state = sh(returnStdout: true, script: command)
}
 def make_artifacts(APP_TYPE,COMPONENT) {
    if(APP_TYPE == "NGINX" ) {
        command = "zip -r ../${COMPONENT}.zip *"
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
    else if(APP_TYPE == "NODEJS" ) {
        command = "zip -r ${COMPONENT}.zip *"
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com

    }
    else if(APP_TYPE == "java" ) {
        command = "zip -r ${COMPONENT}.zip *"
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
    else if (APP_TYPE == "GOLANG") {
        command = "zip -r ${COMPONENT}.zip *"
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
 }