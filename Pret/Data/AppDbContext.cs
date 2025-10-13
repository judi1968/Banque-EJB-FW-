using Pret.Models;
using Microsoft.EntityFrameworkCore;

namespace Pret.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
        }
        public DbSet<MouvementPret> MouvementPret { get; set; }
        public DbSet<Personne> Personne { get; set; }

        public DbSet<MontantPersonne> MontantPersonne { get; set; }
    }
}
