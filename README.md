# Spring Boot OAuth2 Resource Server with Auth0

This project demonstrates how to build a Spring Boot application that protects endpoints using OAuth2 JWT tokens issued by Auth0.

- `/public` — accessible by anyone
- `/private` — accessible **only** with a valid Bearer token from Auth0

---

## ✅ Step 1: Sign Up on Auth0

1. Go to [https://auth0.com](https://auth0.com) and **create a free account**
2. After signing in, you'll land in the Auth0 **Dashboard**

---

## ✅ Step 2: Create a Machine-to-Machine Application

1. Go to `Applications` → `Applications`
2. Click **"Create Application"**
   - Name: e.g. `My Spring App`
   - Type: **Machine to Machine Applications**
3. On the next screen, under **"Select an API"**, choose **"Auth0 Management API"** or create your own if you want to define a custom audience
4. Click **"Authorize"**

---

## ✅ Step 3: Get an Access Token from the Test Tab

1. Go to `Applications` → `APIs`
2. Click the API you authorized earlier
3. Go to the **"Test"** tab
4. Copy the **first curl command** shown (usually labeled "Request token")

It will look like this:

```bash
curl --request POST \
  --url https://<YOUR_DOMAIN>.auth0.com/oauth/token \
  --header 'content-type: application/json' \
  --data '{"client_id":"<CLIENT_ID>","client_secret":"<CLIENT_SECRET>","audience":"<API_IDENTIFIER>","grant_type":"client_credentials"}'
```

## ✅ Step 4: Make the call to private endpoint

```bash
curl -H "Authorization: Bearer token_from_previous_curl_response" http://localhost:8080/private
```

you should see something like:
```bash
Hello yJGpFJRaWWhZDdbDSq2auF4DJC4xCCbC@clients
```