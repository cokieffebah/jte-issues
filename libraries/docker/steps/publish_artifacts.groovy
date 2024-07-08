package library.docker.steps

void call() {
  stage("${env.GIT_STATUS_PREFIX}publish artifacts") {
    if (config.dockerImage == null) {
      error "no docker image found in config: ${config}"
    }

    echo "publishing docker image ${config.dockerImage}"

    if (config.push_commit) {
      config.dockerImage.push()
    }

    if (env.TAG_NAME) {
      config.dockerImage.push(env.TAG_NAME)
    }

    if (config.push_latest) {
      config.dockerImage.push('latest')
    }
  }
}
