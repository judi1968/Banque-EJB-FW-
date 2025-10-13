using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Depot.Models
{
    [Table("mouvement_depot")] // correspond exactement au nom de la table MySQL
    public class MouvementDepot
    {
        [Key]
        [Column("id_mouvement")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdMouvement { get; set; }

        [Column("id_personne")]
        public int IdPersonne { get; set; }

        [Column("montant_entrer", TypeName = "decimal(15,5)")]
        public decimal MontantEntrer { get; set; }

        [Column("montant_sortie", TypeName = "decimal(15,5)")]
        public decimal MontantSortie { get; set; }

        [Column("date_mouvement")]
        public DateTime DateMouvement { get; set; }
    }
}
