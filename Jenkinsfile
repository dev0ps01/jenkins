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
envinorment {
PROJECT_NAME ="Todoapp"
}
stages {
stage('one') {
steps{
sh "echo ${PROJECT_NAME}"
}
}
}
}