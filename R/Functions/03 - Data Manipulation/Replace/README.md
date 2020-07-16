### `replace` {base} ([source](https://www.rdocumentation.org/packages/base/versions/3.6.2/topics/replace))
```{r}
(df <- list(
  a = rbinom(20, 10, 0.5),
  b = "this element needs replacing"
))
replace(df, "old", "new")

```