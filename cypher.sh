#!/bin/bash

if [ $encrypted_43b7d2f1321f_key ];then
  openssl aes-256-cbc -K $encrypted_43b7d2f1321f_key -iv $encrypted_43b7d2f1321f_iv -in cypher.enc -out cypher -d
  cat cypher > ~/.ssh/id_rsa
  chmod 600 ~/.ssh/id_rsa
  echo "Add docker server success"

fi

cp -f config/checkstyle/checkStyle.xml config/checkstyle/checkStyleAll.xml
