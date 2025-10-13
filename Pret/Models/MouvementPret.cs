using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Pret.Models
{
    [Table("mouvement_pret")]
    public class MouvementPret
    {
        [Key]
        [Column("id_mouvement")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdMouvement { get; set; }

        [Column("id_personne")]
        public int IdPersonne { get; set; }

        [Column("montant_entrer")]
        public double MontantEntrer { get; set; }

        [Column("montant_sortie")]
        public double MontantSortie { get; set; }

        [Column("date_mouvement", TypeName = "timestamp without time zone")]
        public DateTime DateMouvement { get; set; }
    }
}
