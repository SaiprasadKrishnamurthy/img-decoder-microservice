#!/bin/sh
QRCODE=`base64 -i $1`
BARCODE=`base64 -i $2`
JSON="{\"qrCodeBase64\": \"$QRCODE\", \"barCodeBase64\": \"$BARCODE\"}"
echo "$JSON" | pbcopy
echo "Request is generated and copied into your clipboard! Now paste it in Swagger UI"
