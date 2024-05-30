Validates that the given value is a valid host name

```kotlin
val domainNameField = HostnameValidable(
    "Invalid domain name"
)
```

> According to [RFC 2606](https://www.rfc-editor.org/rfc/rfc2606.html), top-level domains (TLD) : `.example`, `.invalid`, `.localhost`, and `.test` are reserved
and that's why hostnames containing them are not considered valid.