//pipeline{

 //agent {
  //node {
  //label 'agent1'
  //}
  //}
  //stages {

   //stage('Hello') {
   // steps {
   // echo "Hello"
 // }
// }
//}

//post {
//always {
//echo 'post action'
//}
//}
//}

pipeline {
agent any

options {
disableconcurrentbuilds()
}
environment {
PROJECT_NAME ="Todoapp"
UBUNTU_SSH_CRED = credentials('UBUNTU-SSH')
}
stages {
stage('one') {
steps{
sh "echo ${PROJECT_NAME}"
sh "env"
}
}

stage ('two')
{
environment {
PROJECT_NAME ="Todoapp"
}

steps{
sh "echo ${PROJECT_NAME}"
}
}
}
}