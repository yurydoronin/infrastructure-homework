#!/bin/bash
set -e
currentDir=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
rootDir="$currentDir/../../"

(cd "$rootDir" && exec ./tools/scripts/build.sh)
(cd "$rootDir" && exec ./application/buildImage.sh)
(cd "$rootDir" && exec ./persistence/buildImage.sh)

(cd "$rootDir" && exec docker-compose -f ./tools/docker/docker-compose.yml \
  --project-name=people up -d --remove-orphans)
