def nexus() {
    command = "curl -f -v -u admin:vamsi --upload-file users.zip http://172.31.9.137:8081/repository/users/users.zip"
    def execute_state = sh(returnStdout: true, script: command)
}
