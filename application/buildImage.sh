set -e

imageTag=$1

if [ -z "$1" ]
  then
    echo 'No imageTag provided. Latest will be used.'
    imageTag=latest
fi

imageFullName=people:$imageTag

echo [People STARTING] building "$imageFullName"...

# shellcheck disable=SC2102
echo [People] remove old image "$imageFullName"...
(docker rmi -f "$imageFullName")

# shellcheck disable=SC2102
echo [People] creating docker image "$imageFullName"...
(docker build --no-cache -t "$imageFullName" "${BASH_SOURCE%/*}")

echo [People FINISHED] image "$imageFullName" has been built