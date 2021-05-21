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
environment {
PROJECT_NAME ="Todoapp"
}
stages {
stage('one') {
steps{
sh "echo ${PROJECT_NAME}"
}
}

environment {
PROJECT_NAME ="Todoapp"
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