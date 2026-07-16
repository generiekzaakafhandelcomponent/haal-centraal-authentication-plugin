# Haal Centraal Authentication Plugin

A GZAC plugin that provides SAML-based bearer-token authentication for calls to Haal Centraal APIs.

## Getting started

Follow the [Getting Started](documentation/getting-started.md) guide for setup and development instructions.

## Documentation

- [Getting Started](documentation/getting-started.md) — setup and development instructions
- [Example Application](documentation/example-application.md) — running the example app locally
- [Haal Centraal Authentication Plugin](documentation/plugin.md) — plugin reference documentation
- [Release notes](documentation/release-notes.md) — versiegeschiedenis en wijzigingen

## Versioning & compatibility

This plugin is maintained on two branches, one per supported Valtimo major version:

| Branch | Targets             | Version scheme                                             |
|--------|---------------------|------------------------------------------------------------|
| `main` | Valtimo 13, Java 21 | Plain semver: `1.0.0`, `1.1.0`, ...                        |
| `v12`  | Valtimo 12, Java 17 | Semver with a `-V12` suffix: `1.0.0-V12`, `1.1.0-V12`, ... |

Both branches publish under the same Maven coordinate
(`com.ritense.valtimoplugins:haal-centraal-authentication-plugin`) and the same npm package
(`@valtimo-plugins/haal-centraal-authentication-plugin`) — pick the version matching your Valtimo major version;
there's no separate artifact name to remember.

**You are currently on the `v12` branch** (Valtimo 12 / Java 17 / Angular 17). See `main` for the Valtimo 13 variant.

## Contact

Ayub Abdulkader (Ritense)
