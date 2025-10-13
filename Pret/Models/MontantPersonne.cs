using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Pret.Models
{
    [Table("v_montant_personne")] // vue MySQL
    public class MontantPersonne
    {
        [Key]
        [Column("id_personne")]
        public int IdPersonne { get; set; }

        [Column("montant_actuelle")]
        public double MontantActuelle { get; set; }
    }
}
