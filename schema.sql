CREATE TABLE public.financiamentos
(
    id             SERIAL PRIMARY KEY,
    tipo_imovel    text,
    valor          numeric(10, 2),
    prazo_em_meses integer,
    juros_anual    numeric(5, 2),
    area_casa      numeric(10, 2),
    area_terreno   numeric(10, 2),
    num_andar      integer,
    vagas_garagem  integer,
    zona_local     text
);