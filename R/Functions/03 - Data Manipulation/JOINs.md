## `dplyr` JOINS
|Join Type| Description|Returns columns|Matching Type|
|-|-|-|-|
|`inner_join()` | return all rows from ``x`` where there are matching values in ``y``|``x`` and ``y``. , Returns all matches.|
|`left_join()`|return all rows from ``x``, and all columns from ``x`` and ``y``|Rows in ``x`` with no match in ``y`` will have NA values in the new columns. , |Returns all matches|.
|`right_join()`|return all rows from ``y``, and all columns from ``x`` and ``y``|Rows in ``y`` with no match in ``x`` will have NA values in the new columns|Returns all matches|.
|`full_join()`|return all rows and all columns from both ``x`` and ``y``.|Where there are not matching values, returns NA for the one missing.||
|`semi_join()` |return all rows from `x` where there are matching values in `y`| keeping just columns from `x`|A semi join differs from an inner join because an inner join will return one row of `x` for each matching row of `y`, where a semi join will never duplicate rows of `x`.
|`anti_join()`||return all rows from `x` where there are not matching values in `y`|keeping just columns from `x`.|

