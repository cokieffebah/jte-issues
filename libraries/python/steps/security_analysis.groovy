package library.python.steps

void call() {
  String buildTool = config.build_tool ?: 'tox'

  stage("${env.GIT_STATUS_PREFIX}security analysis") {
    env.VIRTUAL_ENV = "/tmp/venv"
    sh "python -m venv ${env.VIRTUAL_ENV}"
    env.PATH        = "${env.VIRTUAL_ENV}/bin:${env.PATH}"

    sh 'mkdir -p reports'

    switch(buildTool) {
      case 'tox':
        sh 'pip install tox'
        sh 'tox -e bandit -- -f html -o reports/sast.html'

        break;
      default:
        error "unsupported build tool: ${config.build_tool}"
    }

    publishHTML(target: [
      reportName: 'Security Analysis',
      reportTitle: 'Security Analysis',
      reportDir: 'reports',
      reportFiles:'sast.html',
      keepAll: true,
      alwaysLinkToLastBuild: false,
      allowMissing: false,
    ])
  }
}
