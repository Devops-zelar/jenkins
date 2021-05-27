folder('CI-Pipelines') {
  displayName('CI Pipelines')
  description('CI Pipelines')
}
pipelineJob('frontend') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
      'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/Devops-zelar/frontend.git')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/main')
          }
        }
      }
      'scriptPath'('jenkinsfile')
      'lightweight'(true)
    }
  }
}

