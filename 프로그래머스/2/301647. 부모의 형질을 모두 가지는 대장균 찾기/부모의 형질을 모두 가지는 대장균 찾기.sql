select a.id,a.genotype,b.genotype as parent_genotype
from ecoli_data A join ecoli_data b
on A.parent_id = b.id
where a.genotype & b.genotype = b.genotype
order by a.id asc;