# Cloud Spanner with SqlDelight

This project is a demo how to use Google Cloud Spanner with SqlDelight.

## Driver

Spanner supports JDBC as well as R2DBC, https://cloud.google.com/spanner/docs/drivers-overview.
This demo uses R2DBC.

## Dialect

Spanner supports two sql dialects, its own, and a Postgresql version.
This demo uses the ANSI part of the Spanner dialect, implemented by the Postgresql dialect.

## Limitations

1. No native Spanner dialect.
2. R2DBC uses `@` as parameter identifier, so parameterized queries are not yet supported.
3. Spanner only supports named binder, bind(columnIndex) throws `UnsupportedOperationException`.
4. Needs unreleased Spanner version 1.2.1
