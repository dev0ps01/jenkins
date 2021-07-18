 folder('CI-Pipelines') {
    displayName('CI Pipelines')
   description('CI Pipelines')
 }

def component = ["users","todo","login","frontend"];

def count=(component.size()-1)
 for (i in 0..count) {
   def j=component[i]
    pipelineJob("CI-Pipelines/${j}-ci") {
        configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
               'triggers' {
                   'hudson.triggers.SCMTrigger' {
                        'spec'('* * * * 1-5')
                        'ignorePostCommitHooks'(false)
                    }
                }
            }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/dev0ps01/'+j+'.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                        }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            //'name'('*/main')
                            'name'('*/tag/*')
                        }
                    }
                }
                'scriptPath'('Jenkinsfile')
                'lightweight'(true)
            }
        }
    }
 }


