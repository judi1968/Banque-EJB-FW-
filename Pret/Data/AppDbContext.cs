using Microsoft.EntityFrameworkCore;
using Pret.Models;

namespace Pret.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
        }

        public DbSet<Personne> Personne { get; set; }
    }
}
