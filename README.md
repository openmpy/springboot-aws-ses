## 고려해야 하는 부분

QR Code S3에 올려서 뿌려주기

## aws 설정

```yaml
aws:
  ses:
    access-key: IAM Access Key
    secret-key: IAM Secret Key
    region: ap-northeast-2
```

## 명령어
```
aws configure
aws ses create-template --cli-input-json file://template.json
```
