using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Pret.Models
{
     [Table("personne")] // Force EF Core à utiliser la table "personne" (minuscule)
    public class Personne
    {
        [Key] // clé primaire
        [Column("id")] // nom exact de la colonne
        public int Id { get; set; }

        [Required] // non nullable
        [MaxLength(50)]
        [Column("nom")]
        public string Nom { get; set; }

        [Required]
        [MaxLength(50)]
        [Column("prenom")]
        public string Prenom { get; set; }

        [Required]
        [Column("datenaissance")]
        public DateTime DateNaissance { get; set; }
    }
}
