#!/usr/bin/env bash
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Set Mirror:
# APACHE_MIRROR=mirrors.cloud.tencent.com/apache
# MAVEN_MIRROR=mirrors.cloud.tencent.com/maven

set -e

docker buildx build --platform linux/arm64,linux/amd64 -t arctic163/lakehouse-benchmark  ./images --push

docker buildx build --platform linux/arm64,linux/amd64 -t arctic163/benchmark-presto -f benchmark-presto.Dockerfile ./images --push

docker buildx build --platform linux/arm64,linux/amd64 -t arctic163/benchmark-trino -f benchmark-trino.Dockerfile ./images --push

docker buildx build --platform linux/arm64,linux/amd64 -t arctic163/benchmark-hive -f benchmark-hive.Dockerfile ./images --push


