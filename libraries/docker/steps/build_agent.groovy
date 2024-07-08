package library.docker.steps

void call(Map args = [:], body) {
  node('docker') {
    String protocol = config.registry_protocol ?: "https"

    docker.withRegistry("${protocol}://${config.registry}", config.credential_id) {
      try {
        body()
      } finally {
        if (config.cleanup == null || config.cleanup) {
          sh "docker rmi ${config.dockerImage.id}"
        }
      }
    }
  }
}
