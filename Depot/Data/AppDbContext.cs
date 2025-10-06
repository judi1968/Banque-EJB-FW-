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
    }
}
