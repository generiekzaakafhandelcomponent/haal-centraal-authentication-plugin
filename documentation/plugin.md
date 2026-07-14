# Plugin Documentation

## Overview

The Haal Centraal Authentication plugin provides SAML-based bearer-token authentication for calls to Haal Centraal
APIs. It exchanges client certificates for a SAML token at a configured Security Token Service (STS), and exposes
that token to other plugins/HTTP clients via `applyAuth(RestClient.Builder)` and `getAuthenticatedHttpClient()`.

This plugin exposes no process actions of its own — it is an authentication provider that other API plugins can
reference as their authentication configuration, not something you link directly to a service task.

## Dependencies

### Backend

```kotlin
dependencies {
    implementation("com.ritense.valtimoplugins:haal-centraal-authentication-plugin:1.0.0")
}
```

### Frontend

```json
{
  "dependencies": {
    "@valtimo-plugins/haal-centraal-authentication-plugin": "1.0.0"
  }
}
```

In your `app.module.ts`:

```typescript
import {
    HaalCentraalAuthenticationPluginModule, haalCentraalAuthenticationPluginSpecification,
} from '@valtimo-plugins/haal-centraal-authentication-plugin';

@NgModule({
    imports: [
        HaalCentraalAuthenticationPluginModule,
    ],
    providers: [
        {
            provide: PLUGIN_TOKEN,
            useValue: [
                haalCentraalAuthenticationPluginSpecification,
            ]
        }
    ]
})
```

## Configuration

| Property          | Type   | Required | Description                                              |
|--------------------|--------|----------|------------------------------------------------------------|
| tokenServiceUrl    | string | Yes      | URL of the STS used to request the SAML token             |
| keystorePath       | string | No       | Path to the client keystore (JKS) used for mTLS            |
| keystoreSecret     | string | No       | Password of the client keystore                            |
| truststorePath     | string | No       | Path to the truststore (JKS); defaults to the JVM truststore |
| truststoreSecret   | string | No       | Password of the truststore                                 |
| connectionTimeout  | number | No       | Connection timeout in milliseconds (default 10000)          |
| responseTimeout    | number | No       | Response timeout in milliseconds (default 10000)            |

## Actions

This plugin exposes no `@PluginAction`s.

## Usage

Configure an instance of this plugin, then have another plugin definition that needs Haal Centraal access
reference it as its authentication provider (the plugin category is `haal-centraal-authentication-plugin`), so its
outgoing requests are authenticated using the SAML token obtained from the configured `tokenServiceUrl`.
