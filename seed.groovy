folder('CI-Pipelines') {
    displayName('CI Pipelines')
   description('CI Pipelines')
}

//def component = ["users","todo","login","frontend"];

//def count=(component.size()-1)
//for (i in 0..count) {
   //def j=component[i]
    pipelineJob('CI-Pipelines/frontend-ci') {
        configure { flowdefinition ->
//            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
//                'triggers' {
 //                   'hudson.triggers.SCMTrigger' {
//                        'spec'('*/2 * * * 1-5')
//                        'ignorePostCommitHooks'(false)
//                    }
//                }
//            }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/dev0ps01/frontend.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                        }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('Jenkinsfile')
                'lightweight'(true)
            }
        }
    }
//}


//def component = ["cart", "catalogue","user","payment","shipping","frontend"];

//def count=(component.size()-1)
//for (i in 0..count) {
//    def j=component[i]
  pipelineJob('CI-Pipelines/users-ci') {
    configure { flowdefinition ->
//            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
//                'triggers' {
        //                   'hudson.triggers.SCMTrigger' {
//                        'spec'('*/2 * * * 1-5')
//                        'ignorePostCommitHooks'(false)
//                    }
//                }
//            }
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/dev0ps01/users.git')
                         'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/main')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
  }
//}

//def component = ["cart", "catalogue","user","payment","shipping","frontend"];

//def count=(component.size()-1)
//for (i in 0..count) {
//    def j=component[i]
 pipelineJob('CI-Pipelines/login-ci') {
    configure { flowdefinition ->
//            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
//                'triggers' {
        //                   'hudson.triggers.SCMTrigger' {
//                        'spec'('*/2 * * * 1-5')
//                        'ignorePostCommitHooks'(false)
//                    }
//                }
//            }
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/dev0ps01/login.git')
                         'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/main')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
 }
//}


//def component = ["cart", "catalogue","user","payment","shipping","frontend"];

//def count=(component.size()-1)
//for (i in 0..count) {
//    def j=component[i]
 pipelineJob('CI-Pipelines/todo-ci') {
    configure { flowdefinition ->
//            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
//                'triggers' {
        //                   'hudson.triggers.SCMTrigger' {
//                        'spec'('*/2 * * * 1-5')
//                        'ignorePostCommitHooks'(false)
//                    }
//                }
//            }
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/dev0ps01/todo.git')
                         'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/main')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
 }
//}