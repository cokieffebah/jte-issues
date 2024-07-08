fields {
  required {
    registry = String
    repository = String
    credential_id = String
  }

  optional {
    registry_protocol = ["http", "https"]
    push_latest = Boolean
    push_commit = Boolean
    cleanup = Boolean
    dockerImage // TODO: workaround, do not set
  }
}
