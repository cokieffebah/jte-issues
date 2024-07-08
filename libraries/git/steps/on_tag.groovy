package library.git.steps

void call(Map args = [:], body) {
  if (!env.TAG_NAME) {
    return
  }

  if (args.branch && CHANGE_BRANCH != args.branch) {
    return
  }

  if (args.match && env.TAG_NAME !=~ args.match) {
    return
  }

  if (args.primary && env.BRANCH_IS_PRIMARY != "true") {
    return
  }

  echo "building for tag ${env.TAG_NAME}"

  body()
}
