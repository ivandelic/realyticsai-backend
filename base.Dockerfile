FROM oracle/graalvm-ce:latest
WORKDIR /wallet
# Wallet folder needs to be unziped in context folder
ADD wallet .