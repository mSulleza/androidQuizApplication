package com.uplb.mark.nasc9;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


public class DatabaseHelper extends SQLiteOpenHelper{

    // TABLE NAME
    public static final String TABLE_NAME = "QUESTIONS";

    // DATABASE COLUMNS
    public static final String COLUMN_ID = "id INT AUTO_INCREMENT,";
    public static final String COLUMN_QTYPE = "question_type INT,";
    public static final String COLUMN_QUESTION = "question VARCHAR,";
    public static final String COLUMN_ANSWER = "answer VARCHAR,";
    public static final String COLUMN_ANSWERED = "answered INT,";
    public static final String COLUMN_CHOICE_1 = "choice_1 VARCHAR,";
    public static final String COLUMN_CHOICE_2 = "choice_2 VARCHAR,";
    public static final String COLUMN_CHOICE_3 = "choice_3 VARCHAR,";
    public static final String COLUMN_CHOICE_4 = "choice_4 VARCHAR";

    // DATABASE NAME
    private static final String DATABASE_NAME = "main_db.db";


    // QTYPE LEGEND:
    // 0 - True or False
    // 1 - Identification
    // 2 - Multiple Choice
    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                    + COLUMN_ID
                    + COLUMN_QTYPE
                    + COLUMN_QUESTION
                    + COLUMN_ANSWER
                    + COLUMN_ANSWERED
                    + COLUMN_CHOICE_1
                    + COLUMN_CHOICE_2
                    + COLUMN_CHOICE_3
                    + COLUMN_CHOICE_4
                    + ");";
    public static final String CREATE_LEVELS_TABLE = "CREATE TABLE IF NOT EXISTS LEVELS(id INT AUTO_INCREMENT, level INT, completed INT);";
    // Database Questions
    public static final String[] INSERT_DATA =
            {"INSERT INTO QUESTIONS VALUES(0, 1, 'He is named as the “Father of Antiseptic Surgery”.', 'Joseph Lister', 0, null, null, null, null);",
                  "INSERT INTO QUESTIONS VALUES(1, 1, 'He was the first man to accurately describe a bacterial cell.', 'Antony van Leeuwenhoek', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(2, 1, 'These are techniques used to prevent microbial contamination.', 'Aseptic techniques', 0, null, null, null, null);" ,
                    "INSERT INTO QUESTIONS VALUES(3, 1, 'This was the first method used for vaccination.', 'Variolation', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(4, 1, 'These are the two types of Vaccines.', 'Attenuated, Inactivated', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(5, 1, 'This scientist used a vaccination procedure to protect individuals from smallpox by the use of cowpox virus.', 'Edward Jenner', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(6, 1, 'This scientist coined the term “Virus” and was the first to develop virus as an entity.', 'Martinus Beijerinck', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(7, 1, 'This scientist discovered the 606th compound SALVARSAN which is an inorganic arsenical to treat syphilis.', 'Paul Ehrlich', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(8, 1, 'Alexander Flemming discovered this compound from a bacteria that inhibits Staphylococcus aureus.', 'Penicillin', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(9, 1, 'These are the three domain systems proposed by Carl Woese.', 'Eukarya, Bacteria, Archaea', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(10, 0, 'Archaea is more closely related to bacteria than to eukarya.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(11, 0, 'Prokaryotes in acidic conditions maintain neutral internal pH.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(12, 0, 'Most pathogens are mesophilic.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(13, 0, 'The process of transforming SO4 to hydrogen sulfide (H2S) is an aerobic process.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(14, 0, 'Anaerobic bacteria degrades the solid portion/sludge during the primary treatment of wastewater.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(15, 0, 'B cells eliminates antigens that are extracellular.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(16, 0, 'STDs can be transmitted through urine.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(17, 0, 'All enzymatic reactions occur in aqueous systems.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(18, 0, 'Lactic acid bacteria can only be used in fermenting dairy products, such as yoghurt.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(19, 0, 'Ready-to-eat foods must receive the least care to prevent contamination.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(20, 2, 'Which does not belong to the group?', 'B', 0, '<i>Yersinia pestis</i>', '<i>Staphylococcus aureus</i>', '<i>Pseudomonas aeruginosa</i>', '<i>Escherichia coli</i>');",
                    "INSERT INTO QUESTIONS VALUES(21, 2, 'Microbes that obtain carbon from carbon dioxide and uses inorganic compounds as source of energy.', 'D', 0, 'Photoautotrophs', 'Chemoheterotrophs', 'Photoheterotrophs', 'Chemoautotrophs');",
                    "INSERT INTO QUESTIONS VALUES(22, 2, 'Which of the following is not a major element in the nutritional requirement of the microbes?', 'C', 0, 'Mg', 'Ca', 'Mn', 'K');",
                    "INSERT INTO QUESTIONS VALUES(23, 2, 'In Lichen association, Algae : Phycobiont :: Fungi : _________.', 'A', 0, 'Mycobiont', 'Phylobiont', 'Phytobiont', 'Mytobiont');",
                    "INSERT INTO QUESTIONS VALUES(24, 2, 'This is the process of fixing carbon dioxide from the atmosphere.', 'A', 0, 'Calvin Cycle', 'Respiration', 'Photosynthesis', 'Transpiration');",
                    "INSERT INTO QUESTIONS VALUES(25, 2, 'This is the process of absolving ammonia to organic forms of nitrogen, nitrates and nitrites.', 'B', 0, 'Ammonification', 'Assimilation', 'Fixation', 'Nitrification');",
                    "INSERT INTO QUESTIONS VALUES(26, 2, 'This is a type of chemical released by an infected body cell to alert nearby cells of the presence of pathogens.', 'B', 0, 'Antibodies', 'Interferons', 'Proteins', 'Lysozomes');",
                    "INSERT INTO QUESTIONS VALUES(27, 2, 'This cell destroys virus-infected cells, release performin lymphokines.', 'B', 0, 'Memory B-cells', 'Cytotoxic T cell', 'Activated B-cells', 'Helper T-cells');",
                    "INSERT INTO QUESTIONS VALUES(28, 2, 'This microorganism is the causative agent for gas gangrene.', 'B', 0, '<i>Clostridium tetani</i>', '<i>Clostridium perfringens</i>', '<i>Plasmodium falciparum</i>', '<i>Plasmodium vivax</i>');",
                    "INSERT INTO QUESTIONS VALUES(29, 2, 'This is a process of removing all microorganisms in/on an inanimate object.', 'D', 0, 'Aseptic technique', 'Disinfection', 'Decontamination', 'Sterilization');",
                    "INSERT INTO QUESTIONS VALUES(30, 1, 'What is the largest known bacteria?', 'Thiomargarita namibiensis', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(31, 1, 'What property of gram negative bacteria is responsible for the induction of fever?', 'Lipid A', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(32, 0, 'Heating at a very high temperature and at a long duration is always an applicable method for food preservation.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(33, 0, 'Spirulina is a species of green algae.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(34, 2, 'This is an enzyme found in some bacteria that can decompose hydrogen peroxide to water and oxygen.', 'D', 0, 'Carboxylase', 'Oxygenase', 'Aldehyde', 'Catalase');",
                    "INSERT INTO QUESTIONS VALUES(35, 2, '<i>Malassezia furfur</i> is the causative agent of what disease?', 'A', 0, 'Dandruff', 'Pimples', 'Body Odor', 'Bad breath');",
                    "INSERT INTO QUESTIONS VALUES(36, 2, 'Which does not belong to the group?', 'C', 0, 'Phagocytes', 'Inflammation', 'Lymphocytes', 'Antimicrobial proteins');",
                    "INSERT INTO QUESTIONS VALUES(37, 0, 'E. coli is commonly not found growing and reproducing in the environment.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(38, 1, 'It is the use of any naturally occurring microorganisms to degrade or detoxify environmental pollutants.', 'Bioremediation', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(39, 0, 'Protozoa can synthesize amino acids and vitamins.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(40, 0, 'Viroids are infectious proteins while viruses are infectious RNA and proteins.', 'False', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(41, 0, 'All coliforms are Gram-negative.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(42, 1, 'What group has the most numerous members inhabiting the soil?', 'Prokaryotes ', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(42, 2, 'This is the process of absolving ammonia to organic forms of nitrogen, nitrates and nitrites.', 'B', 0, 'Ammonification', 'Assimilation', 'Fixation', 'Nitrification');",
                    "INSERT INTO QUESTIONS VALUES(43, 0, '<i>Thiobacillus denitrificans</i> considered as a denitrifying bacteria.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(44, 2, 'This is a mechanism that a bacteria employs when infected by a virus that involves alteration of the gene sequence to prevent future infection of the same virus strain.', 'A', 0, 'CRISPR', 'Vaccination', 'LSTB', 'Immunity');",
                    "INSERT INTO QUESTIONS VALUES(45, 1, 'This microorganism is the causative agent for ulcer and gastroenteritis.', 'Helicobacter pylori', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(46, 0, 'Interferons are serve as defensive response to viruses.', 'True', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(47, 1, 'What is the body’s most accessible portal of entry?', 'Upper respiratory tract', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(48, 1, 'This is also known as foodborne illness or foodborne disease.', 'Food Poisoning', 0, null, null, null, null);",
                    "INSERT INTO QUESTIONS VALUES(49, 2, 'What is the name of the enzyme found in calf-rumen used for curdling milk?', 'A', 0, 'Rennet', 'Koji', 'Shoyu', 'Roisin');",
                    "INSERT INTO LEVELS VALUES(0, 1, 0);",
                    "INSERT INTO LEVELS VALUES(1, 2, 0);",
                    "INSERT INTO LEVELS VALUES(2, 3, 0);",
                    "INSERT INTO LEVELS VALUES(3, 4, 0);",
                    "INSERT INTO LEVELS VALUES(4, 5, 0);"
            };

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_LEVELS_TABLE);
        for (int i = 0; i < INSERT_DATA.length; i += 1)
        {
            sqLiteDatabase.execSQL(INSERT_DATA[i]);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
