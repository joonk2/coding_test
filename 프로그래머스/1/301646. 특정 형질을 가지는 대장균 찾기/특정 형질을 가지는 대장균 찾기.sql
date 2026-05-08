select count(*)
from ECOLI_DATA
where
(2 & GENOTYPE) = 0
and (
(1 & GENOTYPE) = 1
or
(4 & GENOTYPE) = 4
)