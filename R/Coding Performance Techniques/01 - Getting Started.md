# Getting Started

## Getting help in R

### Packages

```R
?tidyverse
```

### Search potential name of function

```R
help.search("read")
```

```txt
[1] readr::readr
```

### Find the package of a function

```R
find("lm")
```

```txt
[1] "package:stats"
```

### Show all potential Functions based on Search

```R
apropos("lm")
```

```txt
[1] ". __C__anova.glm" ".__C__anova.glm.null" ". __C__glm"
[4] ". __C__glm.null" ". __C__lm" ". __C__mlm"
[7] "anova.glm" "anova.glmlist" "anova.lm"
. . .
```

### Check what packages are loaded

```R
search()
```

### Demo Package
```R
window()
demo(package)
```

### Libraries included in `base`

|Library|Description|
|-|-|
|`lattice`  | lattice graphics for panel plots or trellis graphs|
|`MASS`     | package associated with Venables and Ripley’s book entitled Modern Applied Statistics using S-PLUS|
|`mgcv`     | generalized additive models|
|`nlme`     | mixed-effects models (both linear and non-linear)|
|`nnet`     | feed-forward neural networks and multinomial log-linear models|
|`spatial`  | functions for kriging and point pattern analysis|
|`survival` | survival analysis, including penalised likelihood|

### Clear workspace
```R
rm(list = ls())
```
