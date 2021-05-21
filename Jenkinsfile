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
disableConcurrentBuilds()
}
environment {
PROJECT_NAME ="Todoapp"
UB
triggers { cron('H */4 * * 1-5') }

parameters {
        string(name: 'COMPONENT', defaultValue:" ", description: 'which component')

        text(name: 'COMMENT', defaultValue: '', description: 'write a comment about job why are you running it...')

        booleanParam(name: 'FORCE_DEPOLY', defaultValue: true, description: 'check this for force depolyment')

        choice(name: 'ENV', choices: ['dev', 'qa', 'prod'], description: 'Pick an environment')

        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
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