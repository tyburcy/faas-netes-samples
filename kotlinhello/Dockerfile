FROM        rayyildiz/java8:jre8
MAINTAINER  Ramazan AYYILDIZ <rayyildiz@gmail.com>

ENV         KOTLIN_VERSION=1.1.4-2 \
            KOTLIN_HOME=/usr/local/kotlin

RUN         apk update && \
            apk add ca-certificates && \
            update-ca-certificates && \
            apk add openssl wget bash

RUN         cd  /tmp && \
            wget -k "https://github.com/JetBrains/kotlin/releases/download/v${KOTLIN_VERSION}/kotlin-compiler-${KOTLIN_VERSION}.zip"  && \
            unzip "kotlin-compiler-${KOTLIN_VERSION}.zip" && \
            mkdir -p "${KOTLIN_HOME}" && \
            mv "/tmp/kotlinc/bin" "/tmp/kotlinc/lib" "${KOTLIN_HOME}" && \
            rm ${KOTLIN_HOME}/bin/*.bat && \
            chmod +x ${KOTLIN_HOME}/bin/* && \
            ln -s "${KOTLIN_HOME}/bin/"* "/usr/bin/" && \
            apk del wget ca-certificates curl openssl && \
rm -rf /tmp/* /var/cache/apk/*

# Creating Application Source Code Directory

ADD https://github.com/alexellis/faas/releases/download/0.5.1-alpha/fwatchdog /usr/bin
RUN chmod +x /usr/bin/fwatchdog

WORKDIR /root/

COPY Handler.kt .
RUN kotlinc Handler.kt -include-runtime -d Handler.jar

ENV fprocess="java -jar Handler.jar"

HEALTHCHECK --interval=1s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]



