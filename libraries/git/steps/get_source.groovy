void call() {
  try {
    unstash('sourcecode')
  } catch(Exception exc) {
    echo "failed to unstash sourcecode, falling back to checkout.."

    checkout scm
  }
}
