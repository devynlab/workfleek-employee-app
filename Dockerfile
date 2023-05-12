FROM ubuntu:latest
LABEL authors="laban"

ENTRYPOINT ["top", "-b"]