package library.docker.steps

void call() {
  stage("${env.GIT_STATUS_PREFIX}build artifacts") {
    if (!env.GIT_SHA) {
      error "could not get git sha for image tag: ${env.GIT_SHA}"
    }

    config.dockerImage = docker.build("${config.registry}/${config.repository}:${env.GIT_SHA}")
  }
}
