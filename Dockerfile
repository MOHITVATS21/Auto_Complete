FROM ubuntu:latest
LABEL authors="mohitvats"

ENTRYPOINT ["top", "-b"]