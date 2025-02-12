package com.doevida.infrastructure.out.builder;

public class SqlGenerated {

    public static final String getNumberPeopleByState = "SELECT e.estado AS estado, COUNT(p.id) AS total_candidatos FROM pessoa p JOIN endereco e ON p.endereco_id = e.id GROUP BY e.estado ORDER BY e.estado";

    public static final String getPeopleByAgeRange = "SELECT COUNT(id) as total_pessoas, idade, ROUND(AVG(peso/POW(altura, 2)), 2) as imc_media FROM pessoa WHERE idade BETWEEN :minAge AND :maxAge GROUP BY idade";

    public static final String getNumberPeopleObeseByGender = "SELECT genero, ROUND(SUM((peso / (altura * altura)) > 30) / COUNT(*) * 100, 2) AS percentual_obesos FROM pessoa WHERE peso IS NOT NULL AND altura IS NOT NULL AND altura > 0 GROUP BY genero";

    public static final String getNumberPeopleMediaAgeByBoodType = "SELECT tipo_sanguineo, ROUND(AVG(idade), 2) AS media_idade FROM pessoa WHERE idade IS NOT NULL AND tipo_sanguineo IS NOT NULL GROUP BY tipo_sanguineo";

    public static final String numberDonorsByBloodTypeReceiveSql = "WITH compatibilidade AS (\n" +
            "    SELECT 'A+' AS receptor, 'A+' AS doador UNION ALL\n" +
            "    SELECT 'A+', 'A-' UNION ALL\n" +
            "    SELECT 'A+', 'O+' UNION ALL\n" +
            "    SELECT 'A+', 'O-' UNION ALL\n" +
            "    SELECT 'A-', 'A-' UNION ALL\n" +
            "    SELECT 'A-', 'O-' UNION ALL\n" +
            "    SELECT 'B+', 'B+' UNION ALL\n" +
            "    SELECT 'B+', 'B-' UNION ALL\n" +
            "    SELECT 'B+', 'O+' UNION ALL\n" +
            "    SELECT 'B+', 'O-' UNION ALL\n" +
            "    SELECT 'B-', 'B-' UNION ALL\n" +
            "    SELECT 'B-', 'O-' UNION ALL\n" +
            "    SELECT 'AB+', 'A+' UNION ALL\n" +
            "    SELECT 'AB+', 'A-' UNION ALL\n" +
            "    SELECT 'AB+', 'B+' UNION ALL\n" +
            "    SELECT 'AB+', 'B-' UNION ALL\n" +
            "    SELECT 'AB+', 'AB+' UNION ALL\n" +
            "    SELECT 'AB+', 'AB-' UNION ALL\n" +
            "    SELECT 'AB+', 'O+' UNION ALL\n" +
            "    SELECT 'AB+', 'O-' UNION ALL\n" +
            "    SELECT 'AB-', 'A-' UNION ALL\n" +
            "    SELECT 'AB-', 'B-' UNION ALL\n" +
            "    SELECT 'AB-', 'AB-' UNION ALL\n" +
            "    SELECT 'AB-', 'O-' UNION ALL\n" +
            "    SELECT 'O+', 'O+' UNION ALL\n" +
            "    SELECT 'O+', 'O-' UNION ALL\n" +
            "    SELECT 'O-', 'O-'\n" +
            ")\n" +
            "SELECT \n" +
            "    c.receptor AS tipo_sanguineo_receptor,\n" +
            "    COUNT(p.id) AS quantidade_doadores\n" +
            "FROM \n" +
            "    compatibilidade c\n" +
            "LEFT JOIN \n" +
            "    pessoa p\n" +
            "ON \n" +
            "    c.doador = p.tipo_sanguineo\n" +
            "AND \n" +
            "    p.idade BETWEEN 16 AND 69\n" +
            "AND \n" +
            "    p.peso > 50\n" +
            "GROUP BY \n" +
            "    c.receptor";
}
