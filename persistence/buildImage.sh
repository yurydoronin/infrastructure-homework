set -e

imageTag=$1

if [ -z "$1" ]
  then
    echo 'No imageTag provided. Latest will be used.'
    imageTag=latest
fi

imageFullName=people-migrations:$imageTag

echo [Migrations STARTING] building "$imageFullName"...

# shellcheck disable=SC2102
echo [Migrations] remove old image "$imageFullName"...
(docker rmi -f "$imageFullName")

# shellcheck disable=SC2102
echo [Migrations] creating docker image "$imageFullName"...
(docker build --no-cache -t "$imageFullName" "${BASH_SOURCE%/*}")

echo [Migrations FINISHED] image "$imageFullName" has been built