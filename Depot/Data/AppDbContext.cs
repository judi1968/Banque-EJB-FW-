using Microsoft.EntityFrameworkCore;
using Depot.Models;

namespace Depot.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
        }

        public DbSet<Personne> Personne { get; set; }
         public DbSet<MouvementDepot> MouvementDepot { get; set; }
         public DbSet<MontantPersonne> MontantPersonne { get; set; }
    }
}
