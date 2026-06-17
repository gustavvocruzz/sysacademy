INSERT INTO modalidades (nome) VALUES
('Musculação'),
('Jiu-Jitsu'),
('Muay Thai'),
('MMA'),
('Boxe'),
('Crossfit');

INSERT INTO planos(modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 120.00 FROM modalidades WHERE nome = 'Musculação';

INSERT INTO planos(modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00 FROM modalidades WHERE nome = 'Musculação';

INSERT INTO planos(modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 220.00 FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO planos(modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 170.00 FROM modalidades WHERE nome = 'Muay Thai';

INSERT INTO planos(modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 250.00 FROM modalidades WHERE nome = 'MMA';

INSERT INTO planos(modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 190.00 FROM modalidades WHERE nome = 'Boxe';



INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Branca' FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Azul' FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Roxa' FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Marrom' FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Preta' FROM modalidades WHERE nome = 'Jiu-Jitsu';